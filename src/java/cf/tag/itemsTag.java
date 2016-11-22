/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf.tag;

import cf.bean.ItemInfo;
import cf.db.ItemDB;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author nanasemaru
 */
public class itemsTag extends SimpleTagSupport {

    private String tagType;

    public void setTagType(String tagType) {
        this.tagType = tagType;
    }

    @Override
    public void doTag() throws JspException, IOException {
        try {
            PageContext pageContext = (PageContext) getJspContext();
            JspWriter out = pageContext.getOut();
            ItemDB db = new ItemDB();
            ItemInfo item = new ItemInfo();
            if ("all".equalsIgnoreCase(tagType)) {
                
            } else if ("list".equalsIgnoreCase(tagType)) {
                // display the table format
                for (CustomerBean customer : customers) {
                    out.print("<ul>");
                    out.print("<li>Custid:" + customer.getCustId() + "</li>");
                    out.print("<li>Name:" + customer.getName() + "</li>");
                    out.print("<li>Tel:" + customer.getTel() + "</li>");
                    out.print("<li>Age:" + customer.getAge() + "</li>");
                    out.print("</ul>");
                }
            } else {
                out.println("No such type");
            }
        } catch (IOException ioe) {
            System.out.println("Error generating prime: " + ioe);
        }
    }
}
