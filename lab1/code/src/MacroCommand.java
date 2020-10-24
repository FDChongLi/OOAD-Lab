import java.util.ArrayList;
import java.util.List;

public class MacroCommand extends ModifierCommand{
    private String name;
    private List<ModifierCommand> commands;

    public MacroCommand(String name,List<ModifierCommand> commands){
        this.name = name;
        this.commands = commands;
    }

    public MacroCommand(String name){
        this.name = name;
        this.commands = new ArrayList<ModifierCommand>();
    }

    public void add(ModifierCommand modifierCommand){
        commands.add(modifierCommand);
    }

    public void remove(ModifierCommand modifierCommand){
        commands.remove(modifierCommand);
    }

    @Override
    public void excute() {
        for(int i=0;i<commands.size();i++){
            commands.get(i).excute();
        }
    }

    @Override
    public void unexcute() {
        for(int i = commands.size()-1;i>=0;i--){
            commands.get(i).unexcute();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
