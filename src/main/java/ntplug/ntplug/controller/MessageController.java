package ntplug.ntplug.controller;

import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("message")
public class MessageController {
    private List<Map<String, String>> messages = new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>() {{ put("type","Get"); put("date", String.valueOf(new Date())); }});
    }};

    SimpleDateFormat formatForTimeNow = new SimpleDateFormat("'Текущее время' hh:mm:ss");
    String time =  formatForTimeNow.format(new Date());

    @GetMapping("get")
    public List<Map<String, String>> list() {
        return Collections.singletonList(new HashMap<String, String>() {{
            put("type", "Get");
            put("date", time);
        }});
    }

    @PostMapping("post")
    public Map<String, String> create(@RequestBody Map<String, String> message) {

        String login = message.get("login");
        return new HashMap<String, String>() {{ put("login", login); put("date", String.valueOf(time)); }};
    }
}

//fetch('/message/post', {method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify({login: "login", pass: "pass"})}).then(result => console.log(result))