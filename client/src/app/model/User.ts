import { PaymentInfo } from './PaymentInfo';
import { Address } from './Address';

export interface User {
    username: string;
    password: string;
    fullName: string;
    avatar: string;
    dob: Date
    email: string;
    paymentInfo: PaymentInfo;
    address: Address
}