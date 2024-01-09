export interface Product {

    id: number;
    productImageUrl: string;
    productName: string;
    price: number;
    calories: number;
    rating: number;
    numOfReviews: number;
    description: string;
    //favorite:boolean; //this is a customer specific attribute
    tags:string[];
    cuisines:string[];

}
