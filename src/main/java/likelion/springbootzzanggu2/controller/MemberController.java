package likelion.springbootzzanggu2.controller;

import likelion.springbootzzanggu2.domain.Member;
import likelion.springbootzzanggu2.service.MemberService;
import likelion.springbootzzanggu2.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;


/* @Controller는 MemberController라는 클래스가 스프링의 컨트롤러로 동작함을 알려줌
 * @RequestMapping 다음에 있는 members는 url에 /members를 더했을 때 해당 클래스가 동작하게함
 **/
@Controller
@RequestMapping("members")
public class MemberController {
    /*
     * private이라는 접근 제한자는 MemberController 클래스 내에서만 해당 필드에 접근할 수 있게 하고 final은 해당 필드를 초기화 후 변경할 수 없게함, MemberService 타입의 memberService라는 필드를 선언한것
     **/
    private final MemberService memberService;

    /*
     * (예시)
     * 이 것은 생성자입니다.
     * @Autowired라는 어노테이션은 MemberController 객체를 실행해야 할 때 필요한 의존성을 주입해달라고 선언하기 위해 명시하는 어노테이션이며, 생성자 주입 방식을 선언하고 있습니다.
     * MemberController의 필드를 MemberService 타입으로 선언하였지만, 생성자 parameter에는 MemberServiceImpl이 주입되게 함으로써 느슨한 결합(Loosen Coupling)을 구현하였습니다.
     * @참고 : 실제로는 MemberController 생성자의 파라미터에 MemberServiceImpl이 아니라 MemberService로 쓰여있어도 스프링이 알아서 구현체 클래스의 인스턴스 (MemberServiceImpl memberserviceimpl)를 넣어주게 됩니다.
     *       즉, public MemberController(MemberService memberService) {this.memberService = memberService;} 와 같이 작성해도 에러가 없고, 이게 사실 정석입니다.
     *       아래처럼 작성해 둔 이유는, 실제로는 아래와 같이 동작한다는 것을 여러분 눈으로 먼저 보길 바랐던 제 마음이었습니다.
     *       지금, MemberController의 필드가 MemberService 타입의 데이터인데, 생성자로 주입되는 것은 MemberServiceImpl 타입이라는 것을 충분히 음미하시길 바랍니다.
     **/
    @Autowired
    public MemberController(MemberServiceImpl memberServiceImpl) {
        this.memberService = memberServiceImpl;
    }

    /*
     * url에 /new를 더해주면 createForm 메서드가 실행되고 members/createMemberForm를 templates에서 찾아 memberForm이라는 속성을 model 객체에 추가하고 객체인 new Member()로 바뀐다.
     **/
    @GetMapping("new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new Member());
        return "members/createMemberForm";
    }

    /*
     * url에 /new를 더했을 때 create메서드가 실행되고 Member 객체를 매개변수로 받는다. memberService.save(member)는 memberService를 사용하여 Member 객체를 저장하는 역할을 한다.
     * return "redirect:/"은 리다이렉션을 의미함. 이는 작업이 완료된 후에 클라이언트를 다른 경로로 리다이렉션시키는 역할을 함.
     **/
    @PostMapping("new")
    public String create(Member member) {
        memberService.save(member);
        return "redirect:/";
    }

    /*
     * findlAll메서드가 실행되고 Model 객체를 변수로 받고 memberService 클래스의 findAll()로 memberList인 리스트에 회원 정보가 들어오고, templates의 memberList(뷰)가 보여진다.
     **/
    @GetMapping("")
    public String findAll(Model model) {
        List<Member> memberList = memberService.findAll();
        model.addAttribute("memberList", memberList);
        return "members/memberList";
    }
}
