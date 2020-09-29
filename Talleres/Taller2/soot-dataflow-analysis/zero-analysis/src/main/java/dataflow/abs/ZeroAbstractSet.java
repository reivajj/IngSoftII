package dataflow.abs;

import java.util.HashMap;

public class ZeroAbstractSet {

	private final HashMap<String, ZeroAbstractValue> map;

	public ZeroAbstractSet() {
		this.map = new HashMap<String, ZeroAbstractValue>();
	}

	public Boolean hasValue(String variable) {
		return this.map.containsKey(variable);
	}

	public ZeroAbstractValue getValue(String variable) {
		return this.map.get(variable);
	}

	public void setValue(String variable, ZeroAbstractValue value) {
		if (value != null) {
			this.map.put(variable, value);
		}
	}

	public ZeroAbstractSet union(ZeroAbstractSet another) {
		ZeroAbstractSet new_map = new ZeroAbstractSet();
		new_map.putAll(this);
		for (String key : another.map.keySet()) {
			if (this.hasValue(key)) {
				ZeroAbstractValue mergedValue = this.getValue(key).merge(another.getValue(key));
				new_map.setValue(key, mergedValue);
			} else
				new_map.setValue(key, another.getValue(key));
		}
		another.clear(); // Tengo que limpiar el conjunto viejo?
		this.clear();
		return new_map; // Deberia limpiar los dos viejos y crear uno nuevo? en vez de retornar this?
	}

	public void clear() {
		this.map.clear();
	}

	public void putAll(ZeroAbstractSet another) {
		this.map.putAll(another.map);
	}

}
