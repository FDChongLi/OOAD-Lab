public class FrontAddCommand extends ModifierCommand{
    private Document document;
    private String str;

    public FrontAddCommand(Document document,String str){
        this.document = document;
        this.str = str;
    }

    @Override
    public void excute() {
        document.frontAdd(str);
    }

    @Override
    public void unexcute() {
        document.frontDel(str.length());
    }

    @Override
    public String toString() {
        return "a \""+str+"\"";
    }
}
