import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Modifier modifier = new Modifier();
        Document document = new Document("");
        Scanner scanner = new Scanner(System.in);
        Map<String,ModifierCommand> map = new HashMap<String,ModifierCommand>();

        while (scanner.hasNext()){
            String cmd = scanner.nextLine();
            ModifierCommand nextCMD = parseCommand(cmd,modifier,document,map);
            if(nextCMD!=null){
                modifier.addCommand(nextCMD);
                modifier.invokeNextCommand();
            }
            if(document.isChange()){
                document.print();
                document.setChange(false);
            }
        }

        scanner.close();
    }

    static String getStringArg(String cmd){
        return cmd.split("\"")[1];
    }

    static int getIntArg(String cmd){
        return Integer.parseInt(cmd.split(" ")[1]);
    }

    static String getMacroName(String command){
        return command.substring(1);
    }

    static ModifierCommand parseCommand(String cmd,Modifier modifier,Document document,Map<String,ModifierCommand> map){
        ModifierCommand modifierCommand = null;
        switch (cmd.charAt(0)){
            case 's':
                document.print();
                break;
            case 'a':
                modifierCommand = new FrontAddCommand(document,getStringArg(cmd));
                break;
            case 'A':
                modifierCommand = new EndAddCommand(document,getStringArg(cmd));
                break;
            case 'd':
                modifierCommand = new FrontDelCommand(document,getIntArg(cmd));
                break;
            case 'D':
                modifierCommand = new EndDelCommand(document,getIntArg(cmd));
                break;
            case 'l':
                modifier.printLastNCommands(getIntArg(cmd));
                break;
            case 'u':
                modifier.undo();
                break;
            case 'r':
                modifier.invokeNextCommand();
                break;
            case 'm':
                List<ModifierCommand> commands = modifier.getLastNCommands(getIntArg(cmd),document);
                String name = cmd.split(" ")[2];
                map.put(name,new MacroCommand(name,commands));
                break;
            default:
                modifierCommand = map.get(getMacroName(cmd));
        }

        return modifierCommand;
    }
}
