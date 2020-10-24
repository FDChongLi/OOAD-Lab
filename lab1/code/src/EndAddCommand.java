public class EndAddCommand extends ModifierCommand {
    private Document document;
    private String str;

    public EndAddCommand(Document document,String str){
        this.document = document;
        this.str = (str!=null)?str:"";
    }

    @Override
    public void excute() {
        document.endAdd(str);
    }

    @Override
    public void unexcute() {
        document.endDel(str.length());
    }

    @Override
    public String toString() {
        return "A \""+str+"\"";
    }
}