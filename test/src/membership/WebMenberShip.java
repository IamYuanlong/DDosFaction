package membership;


public class WebMenberShip
{

	public static int getWebRuleOne(float anrc)
	{
		int j = 0;
		int i = 0;
		i = (int)anrc;
		if (2<= i && i <5)
		{
			j = 1;

		} else if (8 > i && i >=5)
		{
			j = 2;

		} else if (i >8 )
		{
			j = 3;
		}
		
		return j;
	}
	
	public static int getWebRuleTwo(float sever)
	{
		int j = 0;
		float i = 0;
		i = sever;
		if (0.97>= i && i >=0.92)
		{
			j = 1;

		} else if (0.92> i && i >=0.88)
		{
			j = 2;

		} else if (i<0.88 )
		{
			j = 3;
		}
		
		return j;
	}
	
	public static int getCPUService(double s)
	{
		int cpuservice = 0;
		double service = s;
		if (service <0.125&&service>0.25) {
			cpuservice = 1;
		} else if (service >0.25&&service<=0.5) {
			cpuservice = 2;
		} else if (service >=0.5) {
			cpuservice = 3;
		}
		return cpuservice;
	}
	


	
}
