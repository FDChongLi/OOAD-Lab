public class Document {
    private String content;
    private boolean change;

    public Document(String content){
        this.content = content;
        this.change = false;
    }

    /**
     * Add str to the end of content
     * @param str
     */
    public void endAdd(String str){
        content += (str!=null)?str:"";
        change = (str==null||str.equals(""))?false:true;
    }

    /**
     * Delete n chars from the end of content
     * @param n : numbles of chars deleted
     * @return the string deleted
     */
    public String endDel(int n){
        if(n<=0){
            change = false;
            return "";
        }

        String ret = (n>=content.length()) ? content:content.substring(content.length()-n);
        content = (n>=content.length()) ? "":content.substring(0,content.length()-n);
        change = true;

        return ret;
    }

    /**
     * Add str to the front of content
     * @param str
     */
    public void frontAdd(String str){
        content = (str!=null) ? str+content:content;
        change = (str==null||str.equals(""))?false:true;
    }

    /**
     * Delete n chars from the front fo content
     * @param n
     * @return the string deleted
     */
    public String frontDel(int n){
        if(n<=0){
            change=false;
            return "";
        }

        String ret = (n>=content.length()) ? content:content.substring(0,n);
        content = (n>=content.length()) ? "":content.substring(n);
        change = true;

        return ret;
    }

    public boolean isChange() {
        return change;
    }

    public void setChange(boolean change) {
        this.change = change;
    }

    public void print(){
        System.out.println("\""+content+"\"");
    }

    public String getContent() {
        return content;
    }
}
