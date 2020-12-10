## 개발 시 주의사항

- 기본 탬플릿은 index.html입니다.
```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head th:replace="fragments/header :: header"></head>

<body class="sb-nav-fixed">
<nav th:replace="fragments/nav :: nav"></nav>
<div th:replace="fragments/sidenav :: sidenav"></div> 

// 여기에 html tag를 사용하여 개발하면 됩니다.
        
<div th:fragment="fragments/footer :: footer"></div>
<th:block th:include="fragments/config :: config"></th:block>

<script>

// 자바스크립트는 script tag를 열어서 사용하면 됩니다.

</script>

</body>
</html>
```
<br>

- sidenav.html에 본문 내용이 있습니다.
    - 지우지 않고 추가한 이유는 참고하여 본문을 꾸미면 될거같아서 남겨놨습니다. 
```html
...
// 해당 div가 본문 내용을 포함하고 있습니다.
<div id="layoutSidenav_content">
...

```

## 실행 시 주의사항
- Home(localhost:8080)은 index.html입니다. 필요하시면 수정하시면 됩니다.
- java email 기능을 넣을시에는 application.xml 을 gitignore에 추가해주세요.
