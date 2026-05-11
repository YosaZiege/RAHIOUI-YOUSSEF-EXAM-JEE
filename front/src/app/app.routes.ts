import { Routes } from '@angular/router';
import { authGuard } from './guards/auth.guard';

export const routes: Routes = [
  { path: '', redirectTo: '/customers', pathMatch: 'full' },
  {
    path: 'login',
    loadComponent: () => import('./components/login/login').then((m) => m.Login),
  },
  {
    path: 'customers',
    loadComponent: () => import('./components/customers/customers').then((m) => m.Customers),
    canActivate: [authGuard],
  },
  { path: '**', redirectTo: '/customers' },
];
