# action-study

목차
1. [basic-deploy](#basic-deploy)
2. [labeler-actio](#labeler-action)
3. [기타](#기타)
    1. [pull-request 승인수 강제](#pull-request-승인수-강제)

## basic-deploy

한개의 원격 서버에 배포를 하는 방식으로  
빌드와 테스트코드 실행을 병렬로 진행한뒤 모두 `ok` 가 되었을경우 배포를 진행

## labeler-action

label 달아주는 액션으로 기본적인것이지만 라벨별로 정리해서 보는게 편하기도 해서 적용  
현재 적용한 `jimschubert/labeler-action@v1` 액션은  
`.github/labeler.yaml` 파일의 설정을 확인하기때문에 별도로 추가 필요.  

## 기타

깃헙 설정관련해서는 이쪽을 통해 작성 

### pull-request 승인수 강제

PR 를 할때 셀프머지도 가능한데 이것을 막기위해선 무슨 방법이 있나 찾아보니 애초에 github 내에서 설정이 가능했다.  
아래와 같은 플로우를 참고하면 된다.  
1. 특정 repository 이동
2. Settings 클릭
3. Branches 클릭
4. Branch name pattern 이름 기입
    1. 브랜치명은 모두 설정할때는 **/* 으로 설정
5. Require a pull request before merging 체크
6. Require approvals 체크 후 승인갯수 설정 