package com.demo.statusbar;

/**
 * Created by xiangcheng on 16/9/13.
 */
public class ThemeUtils {
    public static int getTheme(int index) {
        int theme = 0;
        switch (index) {
            case 0:
                theme = R.style.BlueTheme;
                break;
            case 1:
                theme = R.style.RedTheme;
                break;
            case 2:
                theme = R.style.BrownTheme;
                break;
            case 3:
                theme = R.style.GreenTheme;
                break;
            case 4:
                theme = R.style.PurpleTheme;
                break;
            case 5:
                theme = R.style.TealTheme;
                break;
            case 6:
                theme = R.style.PinkTheme;
                break;
            case 7:
                theme = R.style.DeepPurpleTheme;
                break;
            case 8:
                theme = R.style.OrangeTheme;
                break;
            case 9:
                theme = R.style.IndigoTheme;
                break;
            case 10:
                theme = R.style.CyanTheme;
                break;
            case 11:
                theme = R.style.LightGreenTheme;
                break;
            case 12:
                theme = R.style.LimeTheme;
                break;
            case 13:
                theme = R.style.DeepOrangeTheme;
                break;
            case 14:
                theme = R.style.BlueGreyTheme;
                break;

        }
        return theme;
    }
}
