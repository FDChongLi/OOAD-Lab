public class FrontDelCommand extends ModifierCommand{
    private Document document;
    private String str;
    private int n;

    public FrontDelCommand(Document document,int n){
        this.document = document;
        this.n = n;
        this.str = null;
    }

    @Override
    public void excute() {
        str = document.frontDel(n);
//        System.out.println(str);
    }

    @Override
    public void unexcute() {
//        System.out.println("add:"+str);
        document.frontAdd(str);
    }

    @Override
    public String toString() {
        return "d "+n;
    }
}
