import { User } from "src/app/standard/user";
import { Test } from "../../admin/test";
import { TestQuestion } from "../../admin/test-question";

export class Questionresponse {
    public que:TestQuestion=new TestQuestion();
    public us:User=new User();
    public qrs:Test=new Test();
    public respDate=new Date();
    public ans:String=new String();
    constructor()
    {

    }
}

