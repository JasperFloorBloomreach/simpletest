package org.example;
import org.hippoecm.repository.HippoRepository;
import org.hippoecm.repository.HippoRepositoryFactory;

import javax.jcr.Node;

public class Test {
    public static void main(String[] args) {
        System.out.println("Hi Marki ...");
        try {
            HippoRepository repository = HippoRepositoryFactory.getHippoRepository("rmi://localhost:1099/hipporepository");
            javax.jcr.Session session = repository.login( "admin", "admin".toCharArray());
            Node node = session.getRootNode().getNode("content/documents/myproject/content/sample-document");
            Node document = node.getNode(node.getName());
            if (document.isNodeType("hippo:document") && document.isNodeType("hippotranslation:translated")) {
                System.out.println("This document is written in the language "
                        + document.getProperty("hippotranslation:locale").getString());
            } else {
                System.out.println("This document is not in a specific language");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
            System.out.println("excpetion");
            System.exit(-1);
        }
        System.exit(0);
    }
}
