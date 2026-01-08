import { Component, OnInit } from '@angular/core';
import { VersionService, VersionResponse } from './core/api/version.service';

@Component({
  selector: 'app-root',
  standalone: true,
  template: `
    <h1>{{ data?.product }}</h1>
    <p><strong>App:</strong> {{ data?.application }}</p>
    <p><strong>Status:</strong> {{ data?.status }}</p>
    <small>{{ data?.timestamp }}</small>
  `
})
export class AppComponent implements OnInit {

  data?: VersionResponse;

  constructor(private versionService: VersionService) {}

  ngOnInit() {
    this.versionService.getVersion().subscribe(res => this.data = res);
  }
}
