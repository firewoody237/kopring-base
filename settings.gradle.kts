
rootProject.name = "kopring-base"

include("kopring-base-api")
include("kopring-base-admin")
include("kopring-base-integrated")

include("kopring-base-integrated:tomcat")
findProject(":kopring-base-integrated:tomcat")?.name = "tomcat"
include("kopring-base-integrated:db")
findProject(":kopring-base-integrated:db")?.name = "db"
include("kopring-base-integrated:common")
findProject(":kopring-base-integrated:common")?.name = "common"
include("kopring-base-integrated:webservice")
findProject(":kopring-base-integrated:webservice")?.name = "webservice"
