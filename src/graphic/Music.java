package graphic;


public class Music
{	
	public Music()
	{
	}
	public static class tempo implements Runnable
	{
		private String musica;
		public tempo(String musica)
		{
			this.musica = musica;
		}
		public void run()
		{
			Audio.play(musica);
		}
	}
}