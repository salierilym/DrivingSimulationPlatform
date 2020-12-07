import request from '@/utils/request'

// 查询驾驶实验列表
export function listSimulation(query) {
  return request({
    url: '/data/simulation/list',
    method: 'get',
    params: query
  })
}

// 查询驾驶实验详细
export function getSimulation(id) {
  return request({
    url: '/data/simulation/' + id,
    method: 'get'
  })
}

// 新增驾驶实验
export function addSimulation(data) {
  return request({
    url: '/data/simulation',
    method: 'post',
    data: data
  })
}

// 修改驾驶实验
export function updateSimulation(data) {
  return request({
    url: '/data/simulation',
    method: 'put',
    data: data
  })
}

// 删除驾驶实验
export function delSimulation(id) {
  return request({
    url: '/data/simulation/' + id,
    method: 'delete'
  })
}

// 导出驾驶实验
export function exportSimulation(query) {
  return request({
    url: '/data/simulation/export',
    method: 'get',
    params: query
  })
}