package membership;


//�������������������

/*1 ������ͬ���쳣IPͬʱ����һ���˿ڵĲ�ͬ�쳣��������10����50����100��������������ȡ��ɢֵ1��2��3��
ͬ��
2 ����ͬһԴIP����ͬһĿ��IP�İ���������1000����5000����10000��������������ȡ��ɢֵ1��2��3��

3 ����5s��Ŀ��IP��ƽ�������ʵ���6��4��2������������ȡ��ɢֵ1��2��3��
4�������̵�CPU����/IP�仯����0.5��0.25��0.125������������ȡ��ɢֵ3��2��*/

public class NetRuleMenberShip
{


/*	����һ���쳣��ip��
	25���ڣ��������ʮ����ͬ���쳣IPͬʱ����һ���˿ڢ�ʱ����ΪDDoS������
	��Ҫ���������ԣ��˿ںš�IP��*/

	public static int getNetRuleOne(int ca)
	{
		int capcount =0;
		int i = 0;
		i = ca;
		if (i >= 10&&i<=50)
		{
			capcount = 1;

		} else if (50 > i && i <=100)
		{

			capcount = 2;
		} else if (i > 100)
		{
			capcount = 3;
		}
		
		return capcount;

	}
	
	
/*	������� �쳣IP��25���ڰ�ƽ������
	25s�ڣ�ͬһԴIP����Ŀ��IP��������
	     ��Ҫ���������ԣ��쳣��IP�İ���ƽ��������*/

	public static int getNetRuleTwo(int ca)
	{
		int j = 0;
		int i = 0;
		i = ca;
		if (5000 > i && i > 1000)
		{
			j = 1;

		} else if (10000 >= i && i >=5000)
		{
			j = 2;

		} else if (i > 10000)
		{
			j = 3;
		}
		
		return j;
	}
	
//	25���ڵ�5��5sƽ�������ʳ��ֳ������½����ơ�
	
	public static int getServiceforddos(double s)
	{
		int serviceforddos = 0;
		double service = s;
		if (service >= 4 && service < 6) {
			serviceforddos = 1;
		} else if (service >= 2 && service < 4) {
			serviceforddos = 2;
		} else if (service < 2) {
			serviceforddos = 3;
		}
		return serviceforddos;
	}
	
	
	/*	�����ģ����̵�CPU�仯
	25s�ڣ��������̵�CPU�ı仯��/IP������Сʱ�������ܹ�����
	��Ҫ�����ԣ����̵�CPUռ���ʣ��ܵ�IP��*/
	
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