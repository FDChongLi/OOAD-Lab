import java.util.ArrayList;
import java.util.List;

public class Modifier {
    private List<ModifierCommand> commands;
    //the first command not invoke
    private int curr;
    //the top command of the list
    private int top;

    public Modifier(){
        commands = new ArrayList<ModifierCommand>();
        curr = 0;
        top = -1;
    }

    public void addCommand(ModifierCommand command){
        //if the right way that not include undo
        if(top==commands.size()-1&&curr==top+1){
            commands.add(command);
            top++;
            //if the way before contains undo
        }else{
            commands.set(curr,command);
            top = curr;
        }
    }

    public void invokeNextCommand(){
        if(curr<=top){
//            System.out.println(curr);
//            System.out.println(commands.get(curr).toString());
            commands.get(curr).excute();
            curr++;
        }
    }

    public void undo(){
        if(curr>0){
//            System.out.println(curr-1);
//            System.out.println(commands.get(curr-1).toString());
            commands.get(curr-1).unexcute();
            curr--;
        }
    }

    public List<ModifierCommand> getLastNCommands(int n,Document document){
        List<ModifierCommand> ret = new ArrayList<ModifierCommand>();

        for(int i=curr-n;i<curr;i++){
            ret.add(Main.parseCommand(commands.get(i).toString(),null,document,null));
        }

        return ret;
    }

    public void printLastNCommands(int n){
        for(int i=1;i<=n;i++){
            System.out.println(""+i+" "+commands.get(curr-i).toString());
        }
    }
}
