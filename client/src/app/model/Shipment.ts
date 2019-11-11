import { Product } from './Product';
import { Address } from './Address';

export class Shipment {
    user: String;
    products: Product[];
    address: Address;
}