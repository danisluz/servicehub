import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

export interface VersionResponse {
  application: string;
  product: string;
  status: string;
  timestamp: string;
}

@Injectable({ providedIn: 'root' })
export class VersionService {

  constructor(private http: HttpClient) {}

  getVersion() {
    return this.http.get<VersionResponse>('/api/v1/version');
  }
}
