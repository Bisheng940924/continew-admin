import axios from 'axios';
import qs from 'query-string';

const BASE_URL = '/system/dept';

export interface DeptRecord {
  id?: string;
  name: string;
  parentId?: string;
  description?: string;
  sort: number;
  status?: number;
  type?: number;
  createUserString?: string;
  createTime?: string;
  updateUserString?: string;
  updateTime?: string;
  children?: Array<DeptRecord>;
  parentName?: string;
  disabled?: boolean;
}

export interface DeptParam {
  name?: string;
  status?: number;
}

export function listDept(params: DeptParam) {
  return axios.get<DeptRecord[]>(`${BASE_URL}/tree`, {
    params,
    paramsSerializer: (obj) => {
      return qs.stringify(obj);
    },
  });
}

export function getDept(id: string) {
  return axios.get<DeptRecord>(`${BASE_URL}/${id}`);
}

export function addDept(req: DeptRecord) {
  return axios.post(BASE_URL, req);
}

export function updateDept(req: DeptRecord, id: string) {
  return axios.put(`${BASE_URL}/${id}`, req);
}

export function deleteDept(ids: string | Array<string>) {
  return axios.delete(`${BASE_URL}/${ids}`);
}
