
public class ShowCommand implements Command{
    private Document document;

    public ShowCommand(Document document){
        this.document = document;
    }

    @Override
    public void excute() {
        System.out.println(document.getContent());
    }
}
