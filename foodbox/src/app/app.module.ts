import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CuisineComponent } from './cuisine/cuisine.component';
import { ProductComponent } from './product/product.component';
import { TagComponent } from './tag/tag.component';
import { UserRolesComponent } from './user-roles/user-roles.component';
import { UserComponent } from './user/user.component';
import { CuisineServiceService } from './cuisine-service.service';
import { ProductServiceService } from './product-service.service';
import { TagServiceService } from './tag-service.service';
import { UserServiceService } from './user-service.service';
import { UserRoleServiceService } from './user-role-service.service';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

const routes:Routes=[
  {path:"user", component: UserComponent },
  {path: "cuisine", component:CuisineComponent},
  {path: "", component: ProductComponent},
  {path: "tag", component: TagComponent},
  {path:"user", component: UserComponent },
  {path: "user-roles", component: UserRolesComponent}
]
@NgModule({
  declarations: [
    AppComponent,
    CuisineComponent,
    ProductComponent,
    TagComponent,
    UserRolesComponent,
    UserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
   HttpClientModule,
  [RouterModule.forRoot(routes)]
  ],
  providers: [ProductServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
