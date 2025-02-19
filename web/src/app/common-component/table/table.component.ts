import {Component, EventEmitter, Input, OnInit, Output, QueryList, ViewChildren} from '@angular/core';
import {ColumnAndStyleModel} from '../../models/ColumnsAndStyles.model';
import {SelectionModel} from '@angular/cdk/collections';
import {MatMenuPanel} from '@angular/material/menu';
import {PageEvent} from '@angular/material/paginator';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss'],
})
export class TableComponent implements OnInit {

  // Table Inputs
  @Input() dataSource!: any;
  @Input() columnsAndStyles!: ColumnAndStyleModel[];
  @Input() selection!: SelectionModel<any>;
  @Input() stickyStart!: boolean;
  @Input() stickyEnd!: boolean;
  @Input() menuAction!: MatMenuPanel;
  @Input() isSelection!: boolean;
  @Input() isAction!: boolean;

  // MatPaginator Inputs
  @Input() totalRecord!: number;
  pageSize = 25;
  pageSizeOptions: number[] = [10, 25, 50, 100];

  // MatPaginator output
  @Output() handlerChangePage = new EventEmitter<PageEvent>();

  displayedColumns!: string[];

  constructor() {
  }

  ngOnInit(): void {
    this.displayedColumns = this.columnsAndStyles.map(val => val.columnName);
    if (this.isSelection) {
      this.displayedColumns.unshift('select-table');
    }
    if (this.isAction) {
      this.displayedColumns.push('action-table');
    }
  }

  isAllSelected(): boolean {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.length;
    // const numRows = 200;
    // console.log(numSelected);
    console.log('numRows', numRows, numSelected === numRows);
    return numSelected === numRows;
  }

  masterToggle(): void {
    if (this.isAllSelected()) {
      this.selection.clear();
      return;
    }

    this.selection.select(...this.dataSource);
  }

  handlerSelectRow(e: Event, row: any): void {
    this.selection.toggle(row);
  }

  print(row: any, element: any): void {
    console.log(row);
    console.log(element);
  }

  handlerPage(event: PageEvent): void {
    this.handlerChangePage.emit(event);
  }

}
