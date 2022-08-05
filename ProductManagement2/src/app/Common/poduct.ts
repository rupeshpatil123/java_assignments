export class Product {

    // "id" : 10001,
    // "sku" : "12345678",
    // "proname" : "Laptop",
    // "description" : "Lenovo ",
    // "unitprice" : 190000.0,
    // "imageurl" : "www.laptopimg",
    // "unitsinstock" : 11,
    // "datecreated" : "2022-10-11",
    // "lastupdated" : "2022-11-11",
    // "categoryid" : 1001,


    constructor(
        public id : number,
        public sku : string,
        public proname: string,
        public description :string,
        public unitprice : number,
        public imageurl : string,
        public unitsinstock: number,
        public datecreated:Date | null,
        public lastupdated: Date | null,
        public categoryid: number



    ){}
}
