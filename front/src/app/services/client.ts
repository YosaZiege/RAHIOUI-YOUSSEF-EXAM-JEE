import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Client } from '../models/client.model';

const BASE = 'http://localhost:8080/api/clients';

@Injectable({ providedIn: 'root' })
export class ClientService {
  private http = inject(HttpClient);

  getAll() { return this.http.get<Client[]>(BASE); }
  getById(id: number) { return this.http.get<Client>(`${BASE}/${id}`); }
  search(nom: string) { return this.http.get<Client[]>(`${BASE}/search?nom=${nom}`); }
  create(c: Omit<Client, 'id'>) { return this.http.post<Client>(BASE, c); }
  update(id: number, c: Omit<Client, 'id'>) { return this.http.put<Client>(`${BASE}/${id}`, c); }
  delete(id: number) { return this.http.delete(`${BASE}/${id}`); }
}
