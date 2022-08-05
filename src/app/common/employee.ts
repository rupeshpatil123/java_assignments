export class Employee {
/*  "empno" : 1000,
"ename" : "Yash",
"job" : "President",
"hiredate" : "1991-11-18",
"managerID" : null,
"salary" : 80000,*/

    constructor(
        public empno: number,
        public ename:string,
        public job:string,
        public hiredate:Date | null,
        public managerID:number,
        public salary:number,
        public commission:number,
        public deptno: number
    ){}

}
