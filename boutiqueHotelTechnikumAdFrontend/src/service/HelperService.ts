import { toastController } from '@ionic/vue';

export default class HelperService {
    static async showToast(
        message: string,
        error = false,
        position: 'top' | 'middle' | 'bottom',
        duration = 3000
    ) {
        const toast = await toastController.create({
            message: message,
            duration: duration,
            position: position,
            color: error ? 'danger' : 'success',
        });
        await toast.present();
    }
}
