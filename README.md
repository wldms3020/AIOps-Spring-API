<div align="center">

  <h1>AIOps Dashboard Project</h1>
  
  <p>
    <h3>
      AIOps-Spring-API codes
    </h3>
    <br/>
    <span>
      Gradle 기반으로 Spring Boot 프로젝트를 생성하고 MariaDB로 데이터베이스를 구축한 후
    </span>
    <br/>
    <span>
      JPA를 이용하여 대시보드 서비스 로직 구현
    </span>
  </p>
</div>

<br />

<!-- About the Project -->
## :star2: About the Project


<!-- Screenshots -->
### :camera: Screenshots

<div align="center"> 
  <img src="https://placehold.co/600x400?text=Your+Screenshot+here" alt="screenshot" />
</div>


<!-- TechStack -->
### :space_invader: Tech Stack

- Frontend

  ![Vue.js](https://img.shields.io/badge/Vue.js-4FC08D.svg?style=flat-square&logo=vuedotjs&logoColor=white)
  ![JavaScript](https://img.shields.io/badge/Javascript-F7DF1E.svg?style=flat-square&logo=javascript&logoColor=black)
  ![SASS](https://img.shields.io/badge/SASS-hotpink.svg?style=flat-square&logo=SASS&logoColor=white)
  ![Bootstrap](https://img.shields.io/badge/Bootstrap-7952B3?style=flat-square&logo=bootstrap&logoColor=white)
  
  ![Node.js](https://img.shields.io/badge/Node.js-339933?style=flat-square&logo=Node.js&logoColor=white)
  ![NPM](https://img.shields.io/badge/NPM-CB3837.svg?style=flat-square&logo=npm&logoColor=white)
  
- Backend

  ![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?style=flat-square&logo=java&logoColor=white)
  ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-%236DB33F.svg?style=flat-square&logo=springboot&logoColor=white)
  ![Spring Cloud Gateway](https://img.shields.io/badge/Spring%20Cloud%20Gateway-%236DB33F.svg?style=flat-square&logo=spring&logoColor=white)
  
  ![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=flat-square&logo=gradle&logoColor=white)
  ![Hibernate](https://img.shields.io/badge/Hibernate-59666C.svg?style=flat-square&logo=hibernate&logoColor=white)

- Database

  ![MariaDB](https://img.shields.io/badge/MariaDB-003545.svg?style=flat-square&logo=mariadb&logoColor=white)

- DevOps

  ![Jenkins](https://img.shields.io/badge/Jenkins-D24939?style=flat-square&logo=jenkins&logoColor=white)
  ![macOS](https://img.shields.io/badge/mac%20OS-000000?style=flat-square&logo=macos&logoColor=white)
  ![Ubuntu](https://img.shields.io/badge/Ubuntu-E95420?style=flat-square&logo=ubuntu&logoColor=white)

<!-- Features -->
### :dart: Features

- 회원가입 / 로그인 기능
- **log 및 metric 데이터 대시보드 기능**
- **Highcharts로 column, pie 차트 위젯 및 테이블 위젯 표현**
- Spring Cloud Gateway를 이용하여 Gateway API를 구현하고 이를 통하여 Api 호출
- Jenkins로 App, Api 서버 배포

<!-- Contributing -->
## :wave: 느낀점

<a href="https://github.com/Louis3797/awesome-readme-template/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=Louis3797/awesome-readme-template" />
</a>

Spring Boot로 프로젝트를 처음 생성해 보았는데, 함께 사용했던 IntelliJ 툴도 익숙하지 않아서 초반에 많이 헤맸다.  
Gradle은 Maven보다 훨씬 깔끔하고 정돈된 느낌이어서 기회가 된다면 자사 솔루션에도 적용해 보고 싶다.  
JPA에 대한 개념은 알고 있었지만 직접 코드로 표현해보는 것은 처음이었는데,  
현재 팀에서 맡고 있는 솔루션에서도 사용되고 있어서 공부를 위해 @Query를 사용하는 것은 최대한 지양하였다.  
페이징에 대한 인터페이스를 지원하고 있고 관련 레퍼런스도 많아서 추후 솔루션에 페이징 관련 기능을 구현하는 데 도움이 될 것 같다.

## :scroll: 피드백

- Token을 사용한 데이터 통신
- 프로젝트 패키지 구조를 MVC 패턴에 맞춰서 구성할 것
