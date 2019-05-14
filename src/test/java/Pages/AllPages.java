package Pages;


public class AllPages {


        public  HomePage homePage;
        public   CreateList createList;
        public   SettingsPage settingsPage;

        public  AllPages() {
            homePage = new HomePage();
            createList = new CreateList();
            settingsPage = new SettingsPage();
        }
    }

