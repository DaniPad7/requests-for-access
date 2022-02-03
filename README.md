<h1>Request For Access</h1>
<h2>Description</h2>
<p>The Request For Access System manages the process of adding role to users and hence allowing certain permissions in the front and back end of an application. All users can log in, users with associate and admin roles can submit a request to have their privileges elevated while an executive role cannot. An executive role can accept or deny the requests for admins and associates while an admin can only accept an associate request up to the level of admin.</p>
<h2>IMPORTANT</h2>
<p>IMPORTANT: To login as Associate Username: DanPad, Password: MyPassword. To login as ADMIN Username: BKelly, Password:MyPassword1. To login as Executive Username: BillyP, Password:MyPassword2</p>
<p>To enter the h2-console visit http://localhost:8080/h2-console where the link is jdbc:h2:mem:f56fc33a-9cf0-4a99-be08-ee89cc447eb5 and the username is sa and the password is idk.</p>
<h2>Technologies Used</h2>
<ul>
<li>Java 11</li>
<li>Spring Boot</li>
<li>Spring Security</li>
 <li>Spring Web MVC</li>
<li>Apache Maven</li>
<li>Spring Data JPA</li>
<li>H2 In-Memory Database</li>
 <li>Java-Jwt</li>
<li>Hibernate</li>
  <li>Log4j</li>
 <li>Git/Github</li>
</ul>
<h2>Features</h2>
<h3>List of Features</h3>
<ul>
<li>Users can login and logout.</li>
<li>Users are guarded against features in the front-end and resources in the back-end based on their role.</li>
<li>Associate and Admin roles can submit a request for higher privileges in the application.</li>
<li>An access token of type JWT is used for authentication and authorization in both the front and back-end.</li>

</ul>
<h3>To Do's:</h3>
<ul>
  <li>Implement restrictions on what role can approve or reject the request of another role.</li>
  <li>Implement the ability to utilize the refresh token provided by the back-end.</li>
  <li>Implement the feature for users to register.</li>
  <li>Add capability to update personal information.</li>
  <li>Implement OAuth2 framework using KeyCloak.</li>
</ul>
<h2>Getting Started</h2>
<ul> 
<li>Visit this public repository https://github.com/DaniPad7/front-requests-for-access for setting up the client-side of the application.</li>
<li>Install JDK version 11 locally and a Java IDE.</li>
<li>Git clone this repository or download as a zip file.</li>
<li>Open the git clone repository or folder with the Java IDE</li>
<li>Run the Spring Boot ProjectApplication file locally using the IDE or a terminal.</li>
</ul>
<h2>Licenses</h2>
<p><a href="https://opensource.org/licenses/MIT">https://opensource.org/licenses/MIT</a></p>
<p><a href="https://www.apache.org/licenses/">https://www.apache.org/licenses/</a></p>
