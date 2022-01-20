# **Group 2 - Key 2 Keto**

## **Set-up Instructions**

1. Clone the HTTPS link to a folder that holds your projects.
2. Open Eclipse, set the workspace to the folder that holds your projects.
3. Select "Import Projects" in the package explorer.
4. In the window that opens, select "General" drop down arrow, and click "Existing Projects into Workspace."
5. Click "Browse" and select the "Key2Keto" Folder. Then click Finish.
6. Navigate to App.java

![image](https://user-images.githubusercontent.com/46533825/150423901-6d3df27b-173f-478b-a081-4a894fe7f747.png)

5. Select the green "Run App" button on the toolbar to start the application.

# **Software Version Description for Key2Keto**

#### Created by Mike Bauer, Christian Young, Kenya Holland
##### Open "Required SVD Template.pdf" to view full development process

## **Features**

### **1. Creating a New Account**
#### Description
When the program starts up, a login screen is shown to the user. If the user has not created
an account yet, they can click the Create Account button to be brought to the account
creation form. There, they will input a username, password, their first and last name,
choose their sex, input their height, weight, and age, and choose which diet type they wish
to follow. These diet types consist of Classic, Light, and Modified Keto. Once the form has
been completed, and every input is valid, the user may click the button at the bottom of the
form to confirm the creation of their account, and to be brought to the main view of the
application.

#### Completed Funcitonality
1. The user is able to click the Create Account button to be brought to an account
creation form
2. The user is able to enter account details, which consist of a username and password
3. The user is then able to enter personal details, which consist of their first and last
name, sex, height, weight, age, and diet type
4. The user is finally able to click a button to create an account, and to be brought to
the main application

### **2. Viewing and Adding Recipes to Meal Planner**
#### Description
When the user clicks on the Recipe tab from the main set of tabs, they will be
prompted to select a day of the week which will populate the lower half of the application.
From there, if the user has already created an account, their recipes for that selected day
will already show. If they have not created an account already, then the left side will be
empty for them to populate by selecting which type of recipe they are trying to pick. A
dropdown will populate for the user to add to the recipes for that day. When the user selects
a recipe from the dropdown and before adding the recipe, the right side will populate the
details of the recipe for the user to look over to determine if they want to add it or not.

#### Completed Functionality
1. The user is able to click on the Recipe tab
2. The user is then able to pick a day of the week
3. The user is then able to pick a recipe category: Breakfast, Entrees, Snacks
4. The user is able to select a recipe from a dropdown list
5. After selecting the recipe from the dropdown, the user is able to view all the details
of the recipe
6. The user is then able to either select a new recipe from the dropdown or add the
recipe to the recipes of the day by clicking the Add button
7. The user can also delete a recipe from the day’s list of recipes and change them

### **3. Edit Account Details**
#### Description
When the main view is showing in the application, the user is able to click a tab at the top of
the window titled “My Account”. Upon clicking it, the user will see a list of their account
details. Here, they may click the edit button to the side of each account detail to change it to
a different valid value. If the user changes a detail, the label showing that detail will update to
show the new value.

#### Completed Functionality
1. The user is able to click on the My Account tab
2. The user is then able to see their account details
3. Finally, the user can then edit any of their account details to a different valid value

### **4. View Dashboard Details**
#### Description
When the main view is showing in the application, the user is able to click a tab at the top of
the window titled “Dashboard”. Upon clicking it, the user will see all of the details and
information that they have selected through the other tabs. They will be able to see the
breakdown of their weekly water intake and hours slept. The water and sleep numbers will
be populated from their interaction of the Tracker tab. They will also be able to view the
goals that they have set for themselves as well the recipes that they have selected for the
day from the Recipe tab.

#### Completed Functionality
1. The user is able to view the daily goals, selected recipes, line charts of daily water
consumption and hours slept.
2. The user will be able to check off the daily goal’s checkboxes as they complete them.

### **5. Tracking sleep, water and adding goals**
#### Description
After the user has logged in or made a new account, they will be brought to the main view.
This view contains several tabs. Once the user selects the Tracker tab, they will be brought
to another screen where they can enter the total amount of sleep/water they had for each
day. They may also add however many goals they want. These goals are daily goals and
can consist of anything. When the user enters the amount of sleep they had for example,
they must click the save button to store that value. Once the save button is clicked, a
pop-up window will show and confirm that everything was saved correctly. All of the
information that is entered in this tab can be seen in the dashboard tab. A list of goals and
two graphs for sleep and water intake for the week.

#### Completed Functionality
1. The user is able to click on the Tracker tab
2. The user is able to select a day of the week
3. The user is able to enter the amount of sleep and/or the amount of water they had
for the day
4. The user is able to click save, and see a confirmation that the information they
entered was saved.
5. The user is able to add one goal at a time, but as many as they want to have for
each day individually.
6. The user is able to click the add button and see a confirmation that the information
they entered was saved.
7. All of the information entered in this tab is saved in tracker and can be viewed in the
dashboard tab

### **6. Generating Shopping List**
#### Description
Upon clicking the Shopping tab, the user will be presented with several options, one of them
allowing the user to save their saved recipes into a shopping list. This will show a popup
window where the user may choose a name and a location for the pdf file.

#### Completed Functionality
A pdf file is generated at the specified name and location with an input recipe list

### **7. View a restaurant meal option**
#### Description
The user might not have the time to cook every single day, so they can view what options
they have for eating out at restaurants. These options can be viewed in the Shopping tab of
the program on the bottom right of the screen. They click the drop down, select a restaurant
they want to eat at, and see what food option is available there for them for the specific diet
plan that they are following.

#### Completed Functionality
1. A user is able to view the Shopping tab
2. A user is able to see a dropdown to click
3. A user is able to click the combobox drop down and view a list of restaurants to
choose from
4. A user is able to click a restaurant name and view the meal

### **8. View weekly macros and ingredients based off chosen recipes**
#### Description
Once a user has selected all of the recipes they want to have for the week, they will go to
the shopping tab to view weekly macros and ingredients. The ingredients for every recipe
they choose for each day will be listed on the left side of the screen. They can also choose
to save a PDF of their shopping list to view all of the ingredients they will need. The total
macros for each day is listed on the top right corner of the screen. This will allow the user to
ensure they are on-track with their Keto diet plan.

#### Completed Functionality
1. A user is able to view the Shopping tab
2. A user is able to view macros for each day
3. A user is able to view ingredients needed for each recipe

### **9. Logout and log back into the software with a stored user**
#### Description
The user may log out of their account at any time. All of their saved recipes, tracking
information, personal information, and etc. will be saved to a .txt file for logging back in.
When the user presses log-out, they will be brought back to the login page. They can enter
the login information they entered previously and their entire account will be loaded back into
the program.

#### Completed Functionality
1. A .txt file is created when the user selects the log-out button.
2. The information is read in when the user enters the login info for that users .txt file

## **Design**
#### **Current Software Components**
![image](https://user-images.githubusercontent.com/46533825/150427738-c80e14cb-b474-407c-b874-8284084795d3.png)
#### Packages
1. **Main** - Contains Scene and Switcher that allows for a place for all views to
be shown and switched
2. **Recipe** - Contains all classes and scenes that have to do with displaying,
storing, or reading recipes.
3. **Account** - Contains all classes that have to do with login, account creation, or
the display of a users information
4. **Dashboard** - Contains scenes that display a user's overview.
5. **Shopping** - Contains classes that pertain to the shopping section of the
program, like shopping lists and instructions for navigating grocery
stores and restaurant menus.
6. **Tracker** - Contains classes pertaining to tracking the user’s water and sleep,
and their daily goals.
7. **Interfaces** - Contains interface classes utilized by other concrete classes.

### **Current Software Layers**
![image](https://user-images.githubusercontent.com/46533825/150428129-773619d1-a516-47ff-bde1-50d01f35c0ea.png)
#### Layers
1. **Layer 1** - UI class. Contains all scenes and allows for smooth
transition between them.
2. **Layer 2** - Interface for all View classes
3. **Layer 3** - UI classes. This layer expands on individual scenes.
4. **Layer 4** - Controller classes. Contain all information that does not pertain to components that are physically visible.
5. **Layer 5** - UI classes. Views that are contained within the second layer’s views that show more precise information.
6. **Layer 6** - Controller classes. Contain all information that does not pertain to components that are physically visible.
7. **Layer 7-8** - Interfaces. FileReaderInterface helps those classes that involve reading from files. 
ShoppingListInterface only pertains to the ShoppingList Class
8. **Layer 9** - Entity classes. AccountSaver connects to MainView. FileReader interface is implemented in
AccountFileReader, RestaurantFileReader, and RecipeFileReader. ShoppingListInterface is implemented in ShoppingList.
9. **Layer 10** - Entity classes. Boundary between RecipeFileReader and Recipe. Contains all recipes 
that are read in from RecipeFileReader.
10. **Layer 11-12** - Entity classes. Concrete classes.
