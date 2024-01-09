import { Component, OnInit } from '@angular/core';
import { UserRoleServiceService } from '../user-role-service.service';

@Component({
  selector: 'app-user-roles',
  templateUrl: './user-roles.component.html',
  styleUrl: './user-roles.component.css'
})
export class UserRolesComponent implements OnInit {
  roles: any[] = [];

  constructor(private userRolesService: UserRoleServiceService) { }

  ngOnInit(): void {
    this.getUserRoles();
  }

  getUserRoles(): void {
    this.userRolesService.getAllUserRoles().subscribe(data => {
      this.roles = data;
    });
  }

}
