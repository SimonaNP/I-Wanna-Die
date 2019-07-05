package com.simonapetrova.iwannnadie.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.simonapetrova.iwannnadie.IWannaDie;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = IWannaDie.WIDTH;
		config.height = IWannaDie.HEIGHT;
		config.title = IWannaDie.TITLE;
		new LwjglApplication(new IWannaDie(), config);

	}
}
