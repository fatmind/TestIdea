package enum_;

import java.util.EnumMap;
import java.util.EnumSet;

public class EnumTest {
	
	// ����һ��enumö�����ͣ���������ʵ��ON��OFF
	public enum State {
		ON, OFF
	};

	public static void main(String[] args) {
		
		// ֱ�ӱ���enum
		for (State s : State.values()) {
			System.out.println(s.name());
		}
		
		System.out.println("------------------");
		
		// switch��enum�Ľ��ʹ��
		State switchState = State.OFF;
		switch (switchState) {
		case OFF:
			System.out.println("OFF");
			break;
		case ON:
			System.out.println("ON");
			break;
		}
		
		System.out.println("------------------");
		
		// EnumSet��ʹ��
		EnumSet<State> stateSet = EnumSet.allOf(State.class);
		for (State s : stateSet) {
			System.out.println(s);
		}
		
		System.out.println("------------------");
		
		// EnumMap��ʹ��
		EnumMap<State, String> stateMap = new EnumMap<State, String>(State.class);
		stateMap.put(State.ON, "v-On");
		stateMap.put(State.OFF, "v-Off");
		for (State s : State.values()) {
			System.out.println(s.name() + ":" + stateMap.get(s));
		}
	}
}
