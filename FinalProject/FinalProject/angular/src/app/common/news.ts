export class News {
    constructor(
        public newsid:number,
        public author:string,
        public title:string,
        public newsurl:string,
        public imageurl:string,
        public content:string,
        public description:string,
        public categoryid:number
    ){}
}
