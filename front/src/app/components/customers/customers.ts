import { Component, inject, signal, OnInit } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Client } from '../../models/client.model';
import { ClientService } from '../../services/client';

@Component({
  selector: 'app-clients',
  imports: [ReactiveFormsModule],
  templateUrl: './customers.html',
  styleUrl: './customers.css',
})
export class Customers implements OnInit {
  private fb = inject(FormBuilder);
  private clientService = inject(ClientService);

  clients = signal<Client[]>([]);
  loading = signal(false);
  showForm = signal(false);
  selectedClient = signal<Client | null>(null);
  clientToDelete = signal<Client | null>(null);

  form = this.fb.group({
    nom: ['', [Validators.required, Validators.minLength(2)]],
    email: ['', [Validators.required, Validators.email]],
  });

  ngOnInit() { this.load(); }

  load() {
    this.loading.set(true);
    this.clientService.getAll().subscribe({
      next: (data) => { this.clients.set(data); this.loading.set(false); },
      error: () => this.loading.set(false),
    });
  }

  onSearch(event: Event) {
    const q = (event.target as HTMLInputElement).value.trim();
    if (q) {
      this.clientService.search(q).subscribe(data => this.clients.set(data));
    } else {
      this.load();
    }
  }

  openCreate() {
    this.selectedClient.set(null);
    this.form.reset();
    this.showForm.set(true);
  }

  openEdit(client: Client) {
    this.selectedClient.set(client);
    this.form.patchValue({ nom: client.nom, email: client.email });
    this.showForm.set(true);
  }

  closeForm() {
    this.showForm.set(false);
    this.selectedClient.set(null);
    this.form.reset();
  }

  saveClient() {
    if (this.form.invalid) return;
    const data = this.form.value as { nom: string; email: string };
    const sel = this.selectedClient();
    (sel ? this.clientService.update(sel.id!, data) : this.clientService.create(data))
      .subscribe(() => { this.closeForm(); this.load(); });
  }

  confirmDelete(client: Client) { this.clientToDelete.set(client); }

  deleteClient() {
    const c = this.clientToDelete();
    if (!c?.id) return;
    this.clientService.delete(c.id).subscribe(() => {
      this.clientToDelete.set(null);
      this.load();
    });
  }

  getInitials(nom: string): string {
    return nom.split(' ').slice(0, 2).map(n => n[0]?.toUpperCase() ?? '').join('');
  }

  getAvatarStyle(nom: string): { [key: string]: string } {
    const g = [
      'linear-gradient(135deg,#7c3aed,#4f46e5)',
      'linear-gradient(135deg,#0ea5e9,#06b6d4)',
      'linear-gradient(135deg,#059669,#0d9488)',
      'linear-gradient(135deg,#d97706,#ef4444)',
      'linear-gradient(135deg,#db2777,#9333ea)',
      'linear-gradient(135deg,#2563eb,#7c3aed)',
    ];
    return { background: g[(nom.charCodeAt(0) + nom.length) % g.length] };
  }
}
