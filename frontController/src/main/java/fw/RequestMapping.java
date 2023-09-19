package fw;

import member.MemberInsertAction;
import product.ProductListAction;

/*
	FrontServlet이 넘겨준 request path를 가지고 실제 실행할 class의 object를 만들어서 return하는 작업을 수행
	-> 미리 request path별 실행할 실제 class를 등록한 설정 파일을 보고 찾을 수 있도록 하거나, annotation으로 정의하면 분석해서 실행할 수 있도록 code가 작성되어 있어야 한다.
	보통 설정은 설정 파일(xml, properties file)이나, bean, or annotation으로 하도록 code 정의.
	그러나, 해당 class에선 frontController pattern이 어떻게 동작하는지 보는 것이므로 if~else if로 처리 
*/
public class RequestMapping {
	public Action mapping(String path) {
		Action action = null;
		// parameter로 전달된 path를 분석해서 등록된 object를 찾아 return하는 code가 작성되어 있어야 한다.
		if (path.equals("/member/insert.do")) { // InsertAcion
			// insert 기능을 수행하는 object
			action = new MemberInsertAction();
		} else if (path.equals("/product/list.do")) { // ProductListAction
			// e.g. 조회 기능을 수행하는 object return
			action = new ProductListAction();
		}	
		return action;
	}
}
