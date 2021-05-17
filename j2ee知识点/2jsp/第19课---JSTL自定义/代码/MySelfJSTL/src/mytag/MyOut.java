package mytag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import java.io.IOException;

public class MyOut implements Tag {

    //<c:out value="值">
    //    body
    //</c:out>
    //    page

    private String value;
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public int doStartTag() throws JspException {
        return Tag.EVAL_BODY_INCLUDE;
        //return Tag.SKIP_BODY;
    }
    public int doEndTag() throws JspException {
        try {
            //可以获取out对象
            JspWriter out = this.pageContext.getOut();
            out.write(value+" 很帅！！！");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Tag.EVAL_PAGE;
        //return Tag.SKIP_PAGE;
    }


    //============================================
    private Tag parent;
    public void setParent(Tag parent) {
        this.parent = parent;
    }
    public Tag getParent() {
        return this.parent;
    }

    private PageContext pageContext;
    public void setPageContext(PageContext pageContext) {
        this.pageContext = pageContext;
    }
    public PageContext getPageContext(){
        return this.pageContext;
    }

    public void release(){}
}
