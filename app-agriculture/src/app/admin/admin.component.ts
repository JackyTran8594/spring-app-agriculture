import { Component, OnInit } from '@angular/core';
import { ADMIN_MENU  } from './admin-menu';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})

export class AdminComponent implements OnInit {

  constructor() { }

  opened: boolean = true;

  menu = ADMIN_MENU;

  ngOnInit(): void {
  }

}
