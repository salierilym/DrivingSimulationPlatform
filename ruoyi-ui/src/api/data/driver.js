import request from '@/utils/request'

// 查询驾驶员列表
export function listDriver(query) {
  return request({
    url: '/data/driver/list',
    method: 'get',
    params: query
  })
}

// 查询驾驶员详细
export function getDriver(id) {
  return request({
    url: '/data/driver/' + id,
    method: 'get'
  })
}

// 新增驾驶员
export function addDriver(data) {
  return request({
    url: '/data/driver',
    method: 'post',
    data: data
  })
}

// 修改驾驶员
export function updateDriver(data) {
  return request({
    url: '/data/driver',
    method: 'put',
    data: data
  })
}

// 删除驾驶员
export function delDriver(id) {
  return request({
    url: '/data/driver/' + id,
    method: 'delete'
  })
}

// 导出驾驶员
export function exportDriver(query) {
  return request({
    url: '/data/driver/export',
    method: 'get',
    params: query
  })
}