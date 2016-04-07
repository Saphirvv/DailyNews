package com.saphir.test.dailynews.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Toast工具类
 * 
 */
public class ToastUtil {
	// Toast
	private static Toast toast;

	/**
	 * ��ʱ����ʾToast
	 * 
	 * @param context ������
	 * @param message �ַ���Ϣ
	 */
	public static void showShort(Context context, CharSequence message) {
		if (null == toast) {
			System.out.println(message+"Toast");
			toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}

	/**
	 * ��ʱ����ʾToast
	 * 
	 * @param context ������
	 * @param message R.string
	 */
	public static void showShort(Context context, int message) {
		if (null == toast) {
			toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}

	/**
	 * ��ʱ����ʾToast
	 * 
	 * @param context ������
	 * @param message �ַ���Ϣ
	 */
	public static void showLong(Context context, CharSequence message) {
		if (null == toast) {
			toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}

	/**
	 * ��ʱ����ʾToast
	 * 
	 * @param context ������
	 * @param message R.string
	 */
	public static void showLong(Context context, int message) {
		if (null == toast) {
			toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}

	/**
	 * �Զ�����ʾToastʱ��
	 * 
	 * @param context ������
	 * @param message �ַ���Ϣ
	 * @param duration λ��
	 */
	public static void show(Context context, CharSequence message, int duration) {
		if (null == toast) {
			toast = Toast.makeText(context, message, duration);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}

	/**
	 * �Զ�����ʾToastʱ��
	 * 
	 * @param context ������
	 * @param message R.string��Ϣ
	 * @param duration λ��
	 */
	public static void show(Context context, int message, int duration) {
		if (null == toast) {
			toast = Toast.makeText(context, message, duration);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}

	/** Hide the toast, if any. */
	public static void hideToast() {
		if (null != toast) {
			toast.cancel();
		}
	}
	
	public static void showShortTop(Context context, CharSequence message) {
		if (null == toast) {
			System.out.println(message+"Toast");
			toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.setGravity(Gravity.CENTER|Gravity.TOP, 0, 250);
		toast.show();
	}
	
	public static void showLongTop(Context context, CharSequence message) {
		if (null == toast) {
			System.out.println(message+"Toast");
			toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.setGravity(Gravity.CENTER|Gravity.TOP, 0, 250);
		toast.show();
	}
}