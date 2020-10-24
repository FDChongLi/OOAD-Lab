public class EndDelCommand extends ModifierCommand{
    private Document document;
    private String str;
    private int n;

    public EndDelCommand(Document document,int n){
        this.n = n;
        this.document = document;
        this.str = null;
    }

    @Override
    public void excute() {
        str = document.endDel(n);
    }

    @Override
    public void unexcute() {
        document.endAdd(str);
    }

    @Override
    public String toString() {
        return "D "+n;
    }
}
