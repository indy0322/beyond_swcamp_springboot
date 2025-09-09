package org.ohgiraffers.handlermethod;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/first")
public class FirstController {
    /* 설명. 핸들러 메소드에서 반환형이 없을 경우 요청경로를 반환한다.(요청 경로가 곧 view) */
//    @GetMapping("/first/regist")
    @GetMapping("/regist")
//    public String regist(){
//        return "first/regist";
//    }
    public void regist() {}

    @PostMapping("/regist")
    public String registMenu(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

        /* 설명. Service 계층의 메소드를 호출하며 비즈니스 로직(insert 트랜잭션)을 성속하고 돌아왔다는 가정 */

        /* 설명. insert 성공 메시지와 함께 성공 페이지로 이동 */
        String message = name + "을(를) 신규 메뉴 목록의 " + categoryCode + "번 카테고리에 "
                + price + "원으로 등록에 성공하였습니다!";
        model.addAttribute("message", message);

//        model.addAttribute("name", name);
//        model.addAttribute("price", price);
//        model.addAttribute("category", categoryCode);
        return "/first/messagePrinter";
    }
}
