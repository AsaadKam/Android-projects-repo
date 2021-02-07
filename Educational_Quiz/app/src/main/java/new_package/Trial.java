package new_package;
public class Trial
{



    public interface Trial_Call_Back
    {
        abstract void method_a();
    }
    private Trial_Call_Back Private_Trial_Call_Back;
    private int x=0;
    public void Implement_Private_Call_Back(  Trial_Call_Back Copy_of_Trial_Call_Back)
    {
        this.Private_Trial_Call_Back= Copy_of_Trial_Call_Back;
    }

    public void Run_Private_Call_Back()
    {
        Private_Trial_Call_Back.method_a();
    }




}