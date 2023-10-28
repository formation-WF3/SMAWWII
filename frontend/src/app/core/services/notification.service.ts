import {Injectable} from '@angular/core';
import {ToastrService} from "ngx-toastr";

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(
    private toastrService: ToastrService
  ) {
  }

  showSuccess(message: string | undefined): void {
    this.toastrService.success(message)
  }

  showError(message: string | undefined): void {
    this.toastrService.error(message)
  }

  showInfo(message: string | undefined): void {
    this.toastrService.info(message)
  }

  showWarning(message: string | undefined): void {
    this.toastrService.warning(message)
  }
}
