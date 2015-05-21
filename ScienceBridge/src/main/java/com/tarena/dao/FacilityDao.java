package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Facility;

public interface FacilityDao {
	// ��ӵķ���
	public abstract Integer addFacility(Facility facility);

	// ɾ���ķ���
	public abstract void deleteFacility(Integer id);

	// �޸ĵķ���
	public abstract void modifyFacility(Facility facility);

	// ȫ����ѯ�ķ���
	public abstract List<Facility> selectFacilityList();

	// �����ݿ���ˮ��Ϊ������ѯ��Ϣ
	public Facility selectFacilityById(Integer id);
	
	// �����ݿ�facilitynameΪ������ѯ��Ϣ
	public List<Facility> selectFacilityByFacilityName(String facilityNames);
	
	// ��ҳ��ѯ�ķ���
	public List<Facility> selectFacilityListByPage(int page, int pageSize);

	// ��ѯ��ҳ��
	public int findTotalPage(int pageSize);

}
