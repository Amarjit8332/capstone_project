import { Component, OnInit } from '@angular/core';
import { TagServiceService } from '../tag-service.service';

@Component({
  selector: 'app-tag',
  templateUrl: './tag.component.html',
  styleUrl: './tag.component.css'
})
export class TagComponent  implements OnInit {
  tags: any[] = [];

  constructor(private tagsService: TagServiceService) { }

  ngOnInit(): void {
    this.getTags();
  }

  getTags(): void {
    this.tagsService.getAllTags().subscribe(data => {
      this.tags = data;
    });
  }

}
